package parsing.activitydiagrams;

import java.util.ArrayList;
import java.util.List;

import parsing.sequencediagrams.Fragment;

public class Activity {
	private String id;
	private String name;
	private ActivityType type;
	private List<Edge> incoming;
	private List<Edge> outgoing;
	private boolean ordered;
	private String sdID;
	private Fragment sd;

	public Activity(String id, String name, String type) {
		this.id = id;
		this.name = name;
		this.incoming = new ArrayList<Edge>();
		this.outgoing = new ArrayList<Edge>();
		this.ordered = false;
		if (type.equals("uml:InitialNode")) {
			this.type = ActivityType.initialNode;
		} else if (type.equals("uml:ActivityFinalNode")) {
			this.type = ActivityType.finalNode;
		} else if (type.equals("uml:CallBehaviorAction")) {
			this.type = ActivityType.call;
		} else if (type.equals("uml:DecisionNode")) {
			this.type = ActivityType.decision;
		} else if (type.equals("uml:MergeNode")) {
			this.type = ActivityType.merge;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getIncoming() {
		return incoming;
	}

	public void setIncoming(List<Edge> incoming) {
		this.incoming = incoming;
	}

	public void addIncoming(Edge edge) {
		this.incoming.add(edge);
	}

    public List<Edge> getOutgoing() {
        return outgoing;
    }

    public int getOutgoingCount() {
        return outgoing.size();
    }

	public void setOutgoing(List<Edge> outgoing) {
		this.outgoing = outgoing;
	}

	public void addOutgoing(Edge edge) {
		this.outgoing.add(edge);
	}

	public String getId() {
		return id;
	}

	public ActivityType getType() {
		return type;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public String getSdID() {
		return sdID;
	}

	public void setSdID(String sdID) {
		this.sdID = sdID;
	}

	public Fragment getSd() {
		return sd;
	}

	public void setSd(Fragment sd) {
		this.sd = sd;
	}

	public void print() {
		System.out.print("Type: " + this.type + "; Name: " + this.name);
		if (this.sd != null) {
			System.out.println("; SD: " + this.sd.getName());
		} else {
			System.out.println();
		}
	}
}