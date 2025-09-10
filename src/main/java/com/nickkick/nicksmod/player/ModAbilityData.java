package com.nickkick.nicksmod.player;

public class ModAbilityData {
// This class exists for the purpose of checking if an ability has been enabled by the user via a button click
    public static class AreaModeData {
        private boolean enabled = false;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public void toggle() {
            this.enabled = !this.enabled;
        }
    }

}
