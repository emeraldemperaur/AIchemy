package iot.empiaurhouse.mvvm.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import iot.empiaurhouse.mvvm.model.Element;
import iot.empiaurhouse.mvvm.model.ElementBuilder;

public class ChemicalRepository {

    private static ChemicalRepository instance;
    private ArrayList<Element> elementsData = new ArrayList<>();


    public static ChemicalRepository getInstance(){
        if(instance == null){
            instance = new ChemicalRepository();
        }
        return instance;
    }

    //API Call Handler (Simulation)
    public MutableLiveData<List<Element>> getElementsData(){
        setElementsData();

        MutableLiveData<List<Element>> elementMutableLiveData = new MutableLiveData<>();
        elementMutableLiveData.setValue(elementsData);
        return elementMutableLiveData;
    }


    private void setElementsData(){
        Element actinium = new ElementBuilder().setElementSymbol("Ac").setAtomicNumber(89)
                .setElementGroup("Actinide").setAtomicWeight(new BigDecimal(227))
                .setImageUrl("https://media.springernature.com/full/springer-static/image/art%3A10.1038%2Fnchem.2653/MediaObjects/41557_2016_Article_BFnchem2653_Figa_HTML.jpg")
                .setElementName("Actinium").build();
        Element hydrogen = new ElementBuilder().setElementSymbol("H").setAtomicNumber(1)
                .setElementGroup("Nonmetal").setAtomicWeight(new BigDecimal(1.00784))
                .setImageUrl("https://waterionizer.org/wp-content/uploads/h2.jpg")
                .setElementName("Hydrogen").build();
        Element helium = new ElementBuilder().setElementSymbol("He").setAtomicNumber(2)
                .setElementGroup("Noble Gas").setAtomicWeight(new BigDecimal(4.002602))
                .setImageUrl("https://d2cbg94ubxgsnp.cloudfront.net/Pictures/2000x2000fit/8/6/4/129864_gas_cylinders_shutterstock_420168718.jpg")
                .setElementName("Helium").build();
        Element lithium = new ElementBuilder().setElementSymbol("Li").setAtomicNumber(3)
                .setElementGroup("Alkali Metal").setAtomicWeight(new BigDecimal(6.941))
                .setImageUrl("https://www.alzdiscovery.org/assets/content/cognitive_vitality/Report_Lithium-dietary.jpg")
                .setElementName("Lithium").build();
        Element beryllium = new ElementBuilder().setElementSymbol("Be").setAtomicNumber(4)
                .setElementGroup("Alkaline Earth Metal").setAtomicWeight(new BigDecimal(9.012182))
                .setImageUrl("https://www.uewhealth.com/wp-content/uploads/2017/05/beryllium.jpg")
                .setElementName("Beryllium").build();
        Element boron = new ElementBuilder().setElementSymbol("B").setAtomicNumber(5)
                .setElementGroup("Metalloid").setAtomicWeight(new BigDecimal(10.811))
                .setImageUrl("https://www.clinicaladvisor.com/wp-content/uploads/sites/11/2018/12/0817altmedsboron_1268589.jpg")
                .setElementName("Boron").build();
        Element carbon = new ElementBuilder().setElementSymbol("C").setAtomicNumber(6)
                .setElementGroup("Nonmetal").setAtomicWeight(new BigDecimal(12.0107))
                .setImageUrl("https://science4fun.info/wp-content/uploads/2017/07/carbon-element.jpg")
                .setElementName("Carbon").build();
        Element nitrogen = new ElementBuilder().setElementSymbol("N").setAtomicNumber(7)
                .setElementGroup("Nonmetal").setAtomicWeight(new BigDecimal(14.0067))
                .setImageUrl("https://api.time.com/wp-content/uploads/2015/09/gettyimages-128557595.jpg")
                .setElementName("Nitrogen").build();
        Element oxygen = new ElementBuilder().setElementSymbol("O").setAtomicNumber(8)
                .setElementGroup("Chalcogen").setAtomicWeight(new BigDecimal(15.999))
                .setImageUrl("https://www.cecachemicals.com/export/sites/ceca/.content/medias/images/homepage/HP-teaser-image-tamis.jpg_114638208.jpg")
                .setElementName("Oxygen").build();
        Element flourine = new ElementBuilder().setElementSymbol("F").setAtomicNumber(9)
                .setElementGroup("Halogen").setAtomicWeight(new BigDecimal(18.998403))
                .setImageUrl("https://www.solvay.com/sites/g/files/srpend221/files/styles/header/https/media.solvay.com/medias/domain1446/media713/106042-vqwacr55gc.jpg?itok=Lyc0AKI2")
                .setElementName("Flourine").build();
        Element neon = new ElementBuilder().setElementSymbol("Ne").setAtomicNumber(10)
                .setElementGroup("Noble Gas").setAtomicWeight(new BigDecimal(20.1797))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Neon_discharge_tube.jpg/330px-Neon_discharge_tube.jpg")
                .setElementName("Neon").build();
        Element sodium = new ElementBuilder().setElementSymbol("Na").setAtomicNumber(11)
                .setElementGroup("Alkali Metal").setAtomicWeight(new BigDecimal(22.98976928))
                .setImageUrl("https://www.thoughtco.com/thmb/LDARUmytOCV0nJge2MkRp3wSt8g=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-748491805-5b1491971d64040036b61081.jpg")
                .setElementName("Sodium").build();
        Element magnesium = new ElementBuilder().setElementSymbol("Mg").setAtomicNumber(12)
                .setElementGroup("Alkaline Earth Metal").setAtomicWeight(new BigDecimal(24.305))
                .setImageUrl("https://science4fun.info/wp-content/uploads/2019/02/magnesium-element.jpg")
                .setElementName("Magnesium").build();
        Element aluminium = new ElementBuilder().setElementSymbol("Al").setAtomicNumber(13)
                .setElementGroup("Group 13").setAtomicWeight(new BigDecimal(26.9815384))
                .setImageUrl("https://s3.amazonaws.com/nextdesk2/img/aluminum.jpg")
                .setElementName("Aluminium").build();
        Element silicon = new ElementBuilder().setElementSymbol("Si").setAtomicNumber(14)
                .setElementGroup("Group 14").setAtomicWeight(new BigDecimal(28.085))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/e/e9/SiliconCroda.jpg")
                .setElementName("Silicon").build();
        Element phosphorus = new ElementBuilder().setElementSymbol("P").setAtomicNumber(15)
                .setElementGroup("Nonmetal").setAtomicWeight(new BigDecimal(30.973761998))
                .setImageUrl("https://theodoregray.com/PeriodicTable/Samples/015.7/s15s.JPG")
                .setElementName("Phosphorus").build();
        Element sulfur = new ElementBuilder().setElementSymbol("S").setAtomicNumber(16)
                .setElementGroup("Chalcogen").setAtomicWeight(new BigDecimal(32.06))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Sulfur-sample.jpg/1200px-Sulfur-sample.jpg")
                .setElementName("Sulfur").build();
        Element chlorine = new ElementBuilder().setElementSymbol("Cl").setAtomicNumber(17)
                .setElementGroup("Halogen").setAtomicWeight(new BigDecimal(35.45))
                .setImageUrl("https://www.shorelinepools.com//wp-content/uploads/2017/08/chlorine-tabs-1.jpg")
                .setElementName("Chlorine").build();
        Element argon = new ElementBuilder().setElementSymbol("Ar").setAtomicNumber(18)
                .setElementGroup("Noble Gas").setAtomicWeight(new BigDecimal(39.948))
                .setImageUrl("https://i.ytimg.com/vi/FpHzA4QBTLA/maxresdefault.jpg")
                .setElementName("Argon").build();
        Element potassium = new ElementBuilder().setElementSymbol("K").setAtomicNumber(19)
                .setElementGroup("Alkali Metal").setAtomicWeight(new BigDecimal(39.0983))
                .setImageUrl("https://tyda.se/img/ac5e017f67e492cc81875bf2e439b512.jpg")
                .setElementName("Potassium").build();
        Element calcium = new ElementBuilder().setElementSymbol("Ca").setAtomicNumber(20)
                .setElementGroup("Alkaline Earth Metal").setAtomicWeight(new BigDecimal(40.078))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Calcium_unter_Argon_Schutzgasatmosph%C3%A4re.jpg/1200px-Calcium_unter_Argon_Schutzgasatmosph%C3%A4re.jpg")
                .setElementName("Calcium").build();
        Element scandium = new ElementBuilder().setElementSymbol("Sc").setAtomicNumber(21)
                .setElementGroup("Rare-Earth Metal").setAtomicWeight(new BigDecimal(44.955908))
                .setImageUrl("https://aluminiuminsider.com/wp-content/uploads/thumbs/Ultrapure_crystalline_scandium_5_grams-37y0xoiylilujp7enkohs0.jpg")
                .setElementName("Scandium").build();
        Element titanium = new ElementBuilder().setElementSymbol("Ti").setAtomicNumber(22)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(47.867))
                .setImageUrl("https://www.blackrockmetals.com/wp-content/uploads/2018/11/iStock-518502142-copy-e1541546269500.jpg")
                .setElementName("Titanium").build();
        Element vanadium = new ElementBuilder().setElementSymbol("V").setAtomicNumber(23)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(50.9415))
                .setImageUrl("https://testoil.com/wp-content/uploads/2017/05/vanadium.jpg")
                .setElementName("Vanadium").build();
        Element chromium = new ElementBuilder().setElementSymbol("Cr").setAtomicNumber(24)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(51.9961))
                .setImageUrl("https://lh3.googleusercontent.com/proxy/FFc3pIU-kpsb0ZabF2uai0OxXLqoDhIrcn4KxEX-tCaaTD2TQ4PbslIq6ooMC6wxSZlVZG1jqLmCnEv9T0cSV-mNsIQ_nLw18Gd-Fjie7UJ7fnQV5_Q10Q")
                .setElementName("Chromium").build();
        Element manganese = new ElementBuilder().setElementSymbol("Mn").setAtomicNumber(25)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(54.938043))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/8/86/Mangan_1-crop.jpg")
                .setElementName("Manganese").build();
        Element iron = new ElementBuilder().setElementSymbol("Fe").setAtomicNumber(26)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(55.845))
                .setImageUrl("https://science4fun.info/wp-content/uploads/2017/07/iron-element.jpg")
                .setElementName("Iron").build();
        Element cobalt = new ElementBuilder().setElementSymbol("Co").setAtomicNumber(27)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(58.933194))
                .setImageUrl("https://www.bnnbloomberg.ca/polopoly_fs/1.1157378!/fileimage/httpImage/image.jpg_gen/derivatives/landscape_620/rocks-containing-cobalt-something-surge-is-exploring-for-around-the-world.jpg")
                .setElementName("Cobalt").build();
        Element nickel = new ElementBuilder().setElementSymbol("Ni").setAtomicNumber(28)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(58.6934))
                .setImageUrl("https://www.thoughtco.com/thmb/RTDfDbXaVp6aB3t7pBNDT9xPclc=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-157695931-58c38b1c3df78c353cf686f9.jpg")
                .setElementName("Nickel").build();
        Element copper = new ElementBuilder().setElementSymbol("Cu").setAtomicNumber(29)
                .setElementGroup("Transition Metals").setAtomicWeight(new BigDecimal(63.546))
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/NatCopper.jpg/1200px-NatCopper.jpg")
                .setElementName("Copper").build();
        Element zinc = new ElementBuilder().setElementSymbol("Zn").setAtomicNumber(30)
                .setElementGroup("Post Transition Metals").setAtomicWeight(new BigDecimal(65.38))
                .setImageUrl("https://live.staticflickr.com/1453/26233310435_3d9564da44_b.jpg")
                .setElementName("Zinc").build();
        Element gallium = new ElementBuilder().setElementSymbol("Ga").setAtomicNumber(31)
                .setElementGroup("Post Transition Metals").setAtomicWeight(new BigDecimal(69.723))
                .setImageUrl("https://nanografi.com/product_images/uploaded_images/gallium.jpg")
                .setElementName("Gallium").build();
        Element germanium = new ElementBuilder().setElementSymbol("Ge").setAtomicNumber(32)
                .setElementGroup("Metalloid").setAtomicWeight(new BigDecimal(72.630))
                .setImageUrl("https://images-na.ssl-images-amazon.com/images/I/917Csw4C64L._SL1500_.jpg")
                .setElementName("Germanium").build();
        Element arsenic = new ElementBuilder().setElementSymbol("As").setAtomicNumber(33)
                .setElementGroup("Metalloid").setAtomicWeight(new BigDecimal(74.921595))
                .setImageUrl("https://periodictable.com/Samples/SC.Renierite/s15s.JPG")
                .setElementName("Arsenic").build();
        Element selenium = new ElementBuilder().setElementSymbol("Se").setAtomicNumber(34)
                .setElementGroup("Metalloid").setAtomicWeight(new BigDecimal(78.971))
                .setImageUrl("https://theodoregray.com/PeriodicTable/Samples/034.4/s15s.JPG")
                .setElementName("Selenium").build();
        Element bromine = new ElementBuilder().setElementSymbol("Br").setAtomicNumber(35)
                .setElementGroup("Non Metals").setAtomicWeight(new BigDecimal(79.904))
                .setImageUrl("https://theodoregray.com/periodictable/Samples/SC.Bromargyrite/s14s.JPG")
                .setElementName("Bromine").build();
        Element krypton = new ElementBuilder().setElementSymbol("Kr").setAtomicNumber(36)
                .setElementGroup("Noble Gas").setAtomicWeight(new BigDecimal(83.798))
                .setImageUrl("https://images-na.ssl-images-amazon.com/images/I/61xIUK7sAIL._SL1500_.jpg")
                .setElementName("Krypton").build();

        elementsData.add(hydrogen);
        elementsData.add(helium);
        elementsData.add(lithium);
        elementsData.add(beryllium);
        elementsData.add(boron);
        elementsData.add(carbon);
        elementsData.add(nitrogen);
        elementsData.add(oxygen);
        elementsData.add(actinium);
        elementsData.add(flourine);
        elementsData.add(neon);
        elementsData.add(sodium);
        elementsData.add(magnesium);
        elementsData.add(aluminium);
        elementsData.add(silicon);
        elementsData.add(phosphorus);
        elementsData.add(sulfur);
        elementsData.add(chlorine);
        elementsData.add(argon);
        elementsData.add(potassium);
        elementsData.add(calcium);
        elementsData.add(scandium);
        elementsData.add(titanium);
        elementsData.add(vanadium);
        elementsData.add(chromium);
        elementsData.add(manganese);
        elementsData.add(iron);
        elementsData.add(cobalt);
        elementsData.add(nickel);
        elementsData.add(copper);
        elementsData.add(zinc);
        elementsData.add(gallium);
        elementsData.add(germanium);
        elementsData.add(arsenic);
        elementsData.add(selenium);
        elementsData.add(bromine);
        elementsData.add(krypton);



    }

}
