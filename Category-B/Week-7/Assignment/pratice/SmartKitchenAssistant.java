abstract class KitchenTool {
    private int speedLevel = 1;

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
    }

    public abstract String prepare();
}

interface Washable {
    String clean();
}

class Blender extends KitchenTool implements Washable {
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    public String clean() {
        return "Blender rinsed and dried";
    }
}

public class SmartKitchenAssistant {
    public static void main(String[] args) {
        Blender blender = new Blender();

        blender.setSpeedLevel(3);
        System.out.println("Speed: " + blender.getSpeedLevel());

        blender.setSpeedLevel(9);
        System.out.println("After invalid speed: "
                + blender.getSpeedLevel());

        System.out.println(blender.prepare());
        System.out.println(blender.clean());
    }
}