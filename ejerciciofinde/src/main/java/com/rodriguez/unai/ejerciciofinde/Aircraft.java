package com.rodriguez.unai.ejerciciofinde;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
@Entity
public class Aircraft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String model;
private float autonomy;
@OneToOne(mappedBy="aircraft", cascade = CascadeType.ALL)
private Pilot pilot;

public Aircraft() {
	
}

public Aircraft(String model, float autonomy) {
	this.model = model;
	this.autonomy = autonomy;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public float getAutonomy() {
	return autonomy;
}

public void setAutonomy(float autonomy) {
	this.autonomy = autonomy;
}

public Pilot getPilot() {
	return pilot;
}

public void setPilot(Pilot pilot) {
	this.pilot = pilot;
}

@Override
public String toString() {
	return "Aircraft [id=" + id + ", model=" + model + ", autonomy=" + autonomy + ", pilot=" + pilot + "]";
}


}
