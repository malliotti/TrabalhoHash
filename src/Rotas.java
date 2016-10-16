
public class Rotas {
	// route_id
	private String route_id;

	// agency_id
	// private String agency_id;

	// route_short_name
	private String route_short_name;

	// route_long_name
	private String route_long_name;

	// route_desc,
	// private int route_desc;

	// route_type
	private int route_type;

	// route_url,
	// private String route_url;

	// route_color
	private String route_color;

	// route_text_color
	// private String route_text_color

	public Rotas(String id, String shortName, String longName, int type, String color) {
		this.route_id = id;
		this.route_short_name = shortName;
		this.route_long_name = longName;
		this.route_type = type;
		this.route_color = color;
	}

	@Override
	public String toString() {
		return "Rotas [route_id=" + route_id + ", " + "route_short_name=" + route_short_name + ", " + "route_long_name="
				+ route_long_name + ", " + "route_type=" + route_type + ", " + "route_color=" + route_color + "]";
		
	}
}
