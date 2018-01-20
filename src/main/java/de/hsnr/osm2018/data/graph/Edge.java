package de.hsnr.osm2018.data.graph;

import de.hsnr.osm2018.data.utils.EdgeTypeUtils;
import de.hsnr.osm2018.data.utils.OSMMaxSpeedUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Edge {

    private Node mStartNode;
    private Node mDestinationNode;
    private int mLength;
    private short mSpeed;
    private EdgeType mType;

    public Edge(Graph graph, DataInputStream dis) throws IOException {
        this(graph.getNode(dis.readLong()), graph.getNode(dis.readLong()), dis.readInt(), dis.readShort(), EdgeTypeUtils.evaluateEdgeTypeById((int) dis.readShort()));
    }

    public Edge(Node startNode, Node destinationNode, int length, short speed, EdgeType type) {
        this.mStartNode = startNode;
        this.mDestinationNode = destinationNode;
        this.mLength = length;
        this.mType = type;
        if(speed == 0) {
            this.mSpeed = OSMMaxSpeedUtils.evaluateMaxSpeedByEdgeType(this.mType);
        } else {
            this.mSpeed = speed;
        }
    }

    public Node getStartNode() {
        return mStartNode;
    }

    public Node getDestinationNode() {
        return mDestinationNode;
    }

    /* length in meters */
    public int getLength() {
        return mLength;
    }

    /* speed in kilometers per hour */
    public short getSpeed() {
        return mSpeed;
    }

    public EdgeType getType() {
        return mType;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject data = new JSONObject();
        data.put("start", getStartNode().getId());
        data.put("destination", getDestinationNode().getId());
        data.put("length", getLength());
        data.put("speed", getSpeed());
        data.put("type", getType().getName());
        return data;
    }

    public void write(DataOutputStream dos) throws IOException {
        dos.writeLong(getStartNode().getId());
        dos.writeLong(getDestinationNode().getId());
        dos.writeInt(getLength());
        dos.writeShort(getSpeed());
        dos.writeShort((short) getType().getId());
    }

    @Override
    public String toString() {
        return "Edge:\n{\n\tStartNode: " + this.getStartNode() + ",\n\tEndNode: " + this.getDestinationNode() + ",\n\tWith MaxSpeed: " + this.getSpeed() + ",\n\tWithLength: " + this.getLength() + ",\n\tWith EdgeType: " + this.getType();
    }
}