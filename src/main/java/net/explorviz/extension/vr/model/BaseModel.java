package net.explorviz.extension.vr.model;

import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.jasminb.jsonapi.LongIdHandler;
import com.github.jasminb.jsonapi.annotations.Id;

//Needed for cyclical serialization
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "id")
public class BaseModel {

	private static final AtomicLong ID_GENERATOR = new AtomicLong();

	// position data
	private double xPos = 0;
	private double yPos = 0;
	private double zPos = 0;
	private float xQuat, yQuat, zQuat, wQuat;

	@Id(LongIdHandler.class)
	private String id;

	public BaseModel() {
		id = String.valueOf(ID_GENERATOR.incrementAndGet());
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public double[] getPosition() {
		final double[] coordinates = { xPos, yPos, zPos };
		return coordinates;
	}

	public void setPosition(final double[] coordinates) {
		this.xPos = coordinates[0];
		this.yPos = coordinates[1];
		this.zPos = coordinates[2];
	}

	public void setDeltaPosition(final double[] coordinates) {
		this.xPos += coordinates[0];
		this.yPos += coordinates[1];
		this.zPos += coordinates[2];
	}

	public void setPosition(final double x, final double y, final double z) {
		this.xPos = x;
		this.yPos = y;
		this.zPos = z;
	}

	public float[] getQuaternion() {
		final float[] quaternion = { xQuat, yQuat, zQuat, wQuat };
		return quaternion;
	}

	public void setQuaternion(final float[] quaternion) {
		this.xQuat = quaternion[0];
		this.yQuat = quaternion[1];
		this.zQuat = quaternion[2];
		this.wQuat = quaternion[3];
	}

	public void setQuaternion(final float xQuat, final float yQuat, final float zQuat, final float wQuat) {
		this.xQuat = xQuat;
		this.yQuat = yQuat;
		this.zQuat = zQuat;
		this.wQuat = wQuat;
	}

}
