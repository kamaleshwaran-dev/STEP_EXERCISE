abstract class GardenTool {
    public String use() {
        return "Using the tool in the garden";
    }
}

class CuttingTool extends GardenTool {
    public String use() {
        return super.use() + ", blade sharpened first";
    }
}

class Pruner extends CuttingTool {
    public String use() {
        return super.use()
                + ", then trimming branches precisely";
    }
}

public class BackyardToolshedRoutine {
    public static void main(String[] args) {
        CuttingTool cutter = new CuttingTool();
        Pruner pruner = new Pruner();

        System.out.println(cutter.use());
        System.out.println(pruner.use());
    }
}