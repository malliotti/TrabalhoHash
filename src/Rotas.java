
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
		return "Rota [route_id=" + route_id + ", " + "route_short_name=" + route_short_name + ", " + "route_long_name=" + route_long_name + ", " + "route_type=" + route_type + ", " + "route_color="
				+ route_color + "]";

	}

	public String getRoute_id() {
		return route_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((route_id == null) ? 0 : route_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rotas other = (Rotas) obj;
		if (route_id == null) {
			if (other.route_id != null)
				return false;
		} else if (!route_id.equals(other.route_id))
			return false;
		return true;
	}

}
