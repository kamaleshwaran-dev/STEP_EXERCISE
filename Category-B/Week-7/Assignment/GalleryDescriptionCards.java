abstract class ArtPiece {
    private static int counter = 0;
    private final String pieceId;

    ArtPiece() {
        pieceId = "ART-" + (++counter);
    }

    public final String getPieceId() {
        return pieceId;
    }

    public abstract String describe();
}

class Painting extends ArtPiece {
    public String describe() {
        return "Painting: A colorful landscape";
    }
}

class Sculpture extends ArtPiece {
    public String describe() {
        return "Sculpture: A modern abstract form";
    }
}

public class GalleryDescriptionCards {
    public static void main(String[] args) {
        Painting p = new Painting();
        Sculpture s = new Sculpture();

        System.out.println(p.getPieceId() + " - " + p.describe());
        System.out.println(s.getPieceId() + " - " + s.describe());
    }
}