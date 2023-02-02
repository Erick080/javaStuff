package poo;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageFactory {
	private static ImageFactory imgf = new ImageFactory();
	private Map<String, Image> images;

	public static ImageFactory getInstance() {
		return imgf;
	}

	private ImageFactory() {
		images = new HashMap<>();
	}

	private String id2File(String imgId) {
		switch (imgId) {
		case "SID21":
			return ("/imagens/miranhaedit.png");
		case "HID99":
			return ("/imagens/hulkedit.png");
		case "IMID44":
			return ("/imagens/ironedit.png");
		case "TH11":
			return ("/imagens/thanos.png");
		case "WO44":
			return ("/imagens/wolverine.png");
		case "imgBck":
			return("/imagens/Back.png");
		case "C88":
			return("/imagens/cura.png");
		case "ES22":
			return("/imagens/defesa.png");
		case "ESP23":
			return("/imagens/ataque.png");
		default:
			throw new IllegalArgumentException("Invalid image Id");
			
		}
	}

	public ImageView createImage(String imgId) {
		Image img = images.get(imgId);
		if (img == null) {
//			img = new Image(id2File(imgId));
			img = new Image(getClass().getResourceAsStream(id2File(imgId)));
			images.put(imgId, img);
		}

		ImageView imgv = new ImageView(img);
		return imgv;
	}
}
