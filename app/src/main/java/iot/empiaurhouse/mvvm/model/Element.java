package iot.empiaurhouse.mvvm.model;

import java.math.BigDecimal;

public class Element {

    private String elementName;
    private String elementSymbol;
    private Integer atomicNumber;
    private BigDecimal atomicWeight;
    private String elementGroup;
    private String imageUrl;

    public Element(String elementName, String elementSymbol, Integer atomicNumber,
                   BigDecimal atomicWeight, String elementGroup, String imageUrl) {
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.elementGroup = elementGroup;
        this.imageUrl = imageUrl;
    }

    public Element() {
    }


    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementSymbol() {
        return elementSymbol;
    }

    public void setElementSymbol(String elementSymbol) {
        this.elementSymbol = elementSymbol;
    }

    public Integer getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(Integer atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public BigDecimal getAtomicWeight() {
        return atomicWeight;
    }

    public void setAtomicWeight(BigDecimal atomicWeight) {
        this.atomicWeight = atomicWeight;
    }

    public String getElementGroup() {
        return elementGroup;
    }

    public void setElementGroup(String elementGroup) {
        this.elementGroup = elementGroup;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
