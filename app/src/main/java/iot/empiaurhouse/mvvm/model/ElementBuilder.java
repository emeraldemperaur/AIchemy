package iot.empiaurhouse.mvvm.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.util.Random;

public class ElementBuilder {

    private String elementName = "";
    private String elementSymbol = "";
    private Integer atomicNumber = 0;
    private BigDecimal atomicWeight = new BigDecimal(0);
    private String elementGroup = "";
    private String imageUrl = "";
    private int index;

    public ElementBuilder(String elementName, String elementSymbol, Integer atomicNumber, BigDecimal atomicWeight,
                          String elementGroup, String imageUrl) {
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.elementGroup = elementGroup;
        this.imageUrl = imageUrl;
    }

    public ElementBuilder() {

    }

    public ElementBuilder setElementName(String elementName) {
        this.elementName = elementName;
        return this;
    }

    public ElementBuilder setElementSymbol(String elementSymbol) {
        this.elementSymbol = elementSymbol;
        return this;
    }

    public ElementBuilder setAtomicNumber(Integer atomicNumber) {
        this.atomicNumber = atomicNumber;
        return this;
    }

    public ElementBuilder setAtomicWeight(BigDecimal atomicWeight) {
        this.atomicWeight = atomicWeight;
        return this;
    }

    public ElementBuilder setElementGroup(String elementGroup) {
        this.elementGroup = elementGroup;
        return this;
    }

    public ElementBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Element build(){
        return new Element(elementName, elementSymbol, atomicNumber, atomicWeight,
                elementGroup, imageUrl);
    }

    public Element generate(){
        int length = 8;
        boolean letters = true;
        boolean integers = false;
        String createdRawName = RandomStringUtils.random(length, letters, integers);
        String rawsymbol = RandomStringUtils.random(2, letters, false);
        String elementGroup = "Cortexiphan";
        int elementNumber = getRandomNumberInRange(1,200);
        BigDecimal bigDecimal = new BigDecimal(elementNumber);
        String stockUrl = "https://picsum.photos/200/300";
        String symbol = rawsymbol.substring(0, 1).toUpperCase() + rawsymbol.substring(1);
        index = getRandomNumberInRange(1,3);
        String suffix = suffixMaker(index);
        String createdElementName = createdRawName + suffix;

        return new Element(createdElementName, symbol, elementNumber, bigDecimal,
                elementGroup, stockUrl);
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    private String suffixMaker(int index){
        String suffix;

        switch (index){
            case 1:
                suffix = "ium";
                break;
            case 2:
                suffix = "ite";
                break;
            case 3:
                suffix = "ide";
                break;
             default:
                 suffix = "on";

        }

        return suffix;
    }

}
