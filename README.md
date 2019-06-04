# Chemistry
## Elements
All elements are stored in the ``PeriodicTable`` class and can be accessed using the ``get(String elementName)`` method that returns an ``Element`` object.
## Ions
Ions are used for creating [ionic compounds](###Ionic-Compounds). There are three ways to create an ion.
1. To create a non-metal, monotomic ion, use ``Ion(Element element)``
2. To create a metal, monotomic ion, use ``Ion(Element element, int charge)``
3. To create a polyatomic ion, use ``Ion(LinkedHashMap<Element, Integer> ionsElements, String name, int charge)`` by first creating a ``LinkedHashMap<Element, Integer>`` and adding the elements to it ***in order*** and then calling the constructor
## Compounds
### Covalent Compounds
Covalent compunds are created by providing two ``Element`` objects that have an ``isMetal`` value of ``false`` to the ``CovalentCompound`` constructor with their respetive amounts of each element. For example, to create **Xenon tetrafloride** use:
>   ``CovalentCompound XeF4 = new CovalentCompound(PeriodicTable.get("Xe"), 1, PeriodicTable.get("F"), 4);``
### Ionic Compounds
Ionic compounds are created by providing two ``Ion`` objects to the ``IonicCompound`` constructor and how many of each ion the compund contains formatted in this way: ``IonicCompund(Ion cation, int amountOfCation ,Ion anion, int amountOfAnion)`` where the cation is a positively charged ion (a metal or NH4) and the anion is a negatively charged ion (a non-metal or polyatomic ion). For example, to create **Iron (III) oxide** use:
>   ``Ion iron3 = new Ion(PeriodicTable.get("Fe"), 3);``
>
>   ``Ion oxygen = new Ion(PeriodicTable.get("O"));``
>
>   ``IonicCompound Fe2O3 = new IonicCompound(iron3, 2, oxygen, 3);``