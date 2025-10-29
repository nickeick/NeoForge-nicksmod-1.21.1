package com.nickkick.nicksmod.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BonusTree {
    private final List<BonusNode> fullTree;
    private final String name;

    public BonusTree(String name, List<BonusNode> fullTree) {
        this.name = name;
        this.fullTree = fullTree;
    }

    public void addNode(BonusNode node) {
        this.fullTree.add(node);
    }

    public String getName() { return this.name; }
    public List<BonusNode> getFullTree() { return this.fullTree; }

    public int getNodeDepth(BonusNode bonusNode) {
        if (this.fullTree.contains(bonusNode)) {
            if (bonusNode.getRequirements().isEmpty()) {
                return 0;
            } else {
                return Collections.max(bonusNode.getRequirements().stream().map(this::getNodeDepth).toList()) + 1;
            }
        }
        throw new RuntimeException("This node is not in this tree");
    }

    public List<BonusNode> getLeaves() {
        List<BonusNode> leaves = new ArrayList<>();
        for (BonusNode node : this.fullTree) {
            if (node.getChildren().isEmpty()) {
                leaves.add(node);
            }
        }
        return leaves;
    }

    public List<BonusNode> getRoots() {
        List<BonusNode> roots = new ArrayList<>();
        for (BonusNode node : this.fullTree) {
            if (node.getRequirements().isEmpty()) {
                roots.add(node);
            }
        }
        return roots;
    }
}
