package com.nickkick.nicksmod.player;

import com.nickkick.nicksmod.data_map.ModDataMapTypes;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.List;

public class BonusNode {
    private final ModDataMapTypes.BonusData data;
    private final List<BonusNode> requirements;
    private final List<BonusNode> children;

    public BonusNode(ModDataMapTypes.BonusData data) {
        this.data = data;
        this.children = new ArrayList<>();
        this.requirements = new ArrayList<>();
    }

    public ModDataMapTypes.BonusData getData() { return this.data; }

    public List<BonusNode> getChildren() {
        return this.children;
    }

    public void addChildren(BonusNode child) {
        this.children.add(child);
    }

    public void addRequirements(BonusNode requirement) throws LinkLoopException {
        // Cannot set a Bonus as its own requirement
        if (requirement.equals(this)) {
            throw new LinkLoopException("A Bonus cannot be a requirement of itself");
        }
        // Cannot set a Bonus as a requirement if this Bonus is above it in its requirement tree
        List<BonusNode> checkLoop = new ArrayList<>(List.of(requirement));
        while (!checkLoop.isEmpty()) {
            List<BonusNode> new_requirements = checkLoop.getLast().getRequirements();
            if (!new_requirements.isEmpty()) {
                for (BonusNode req : new_requirements) {
                    if (req.equals(this)) {
                        throw new LinkLoopException("A Bonus cannot be a requirement of itself");
                    }
                    checkLoop.add(req);
                }
                checkLoop.remove(checkLoop.size() - new_requirements.size() - 1);
            } else {
                checkLoop.removeLast();
            }
        }
        requirement.addChildren(this);
        this.requirements.add(requirement);
    }

    public void addRequirements(List<BonusNode> requirements) throws LinkLoopException {
        for (BonusNode requirement : requirements) {
            this.addRequirements(requirement);
        }
    }

    public List<BonusNode> getRequirements() {
        return this.requirements;
    }
}
