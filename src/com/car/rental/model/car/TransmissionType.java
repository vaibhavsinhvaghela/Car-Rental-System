package com.car.rental.model.car;

public enum TransmissionType {

    MANUAL("Manual"),
    AUTOMATIC("Automatic");

    private String transmissionType;

    TransmissionType(String transmission){
        this.transmissionType=transmission;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public static TransmissionType fromTransmissionType(String trans_type){
        for(TransmissionType transmissionType:values()){
            if(transmissionType.transmissionType.equalsIgnoreCase(trans_type)){
                return transmissionType;
            }
        }
        return null;
    }
}
