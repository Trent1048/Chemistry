# Chemistry
## Elements
All elements are stored in the ``PeriodicTable`` class and can be accessed using the ``get(String elementName)`` method that returns an ``Element`` object.
## Ions
Ions are used for creating ionic compounds. There are three ways to create an ion.
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

### Metals

The ``Metal`` class is used in and ``Equation`` if there is a metal that is not bonded to anything in it. Metals are created by providing an ``Element`` and charge to the constructor. The ``Element`` must return ``true`` when ``isMetal()`` is called. (because duh)

## Equations

The constructor for ``Equation`` takes in two ``HashMap<Compound, Integer>``, the first one as the reactants of the equation, and the second as the products. The ``Compound`` being what compounds are in that half of the equation and the ``Integer`` being how many of that compound there is. 

### Solving

The ``Equation`` class contains two solving methods: 
>	``solve(String knownCompound, double amountOfCompound, boolean isInMols, String unknownCompound, boolean solveForMols)`` 
>
>	``solveLR(HashMap<String, Double> reactantsWithAmounts, boolean isInMols, String unknownCompound, boolean solveForMols)``

``solve`` will solve for a value in the equation assuming that there are excess amounts of other compounds. It takes in the symbol of the compound that has a known value, that value, if that value is in mols or grams (``true`` is mols, ``false`` is grams), the symbol of the compound to solve for, and weather or not to return it in mols or grams (``true`` is mols, ``false`` is grams)

``solveLR`` will take into account limiting reactants and solve the equation like ``solve()``. It takes in a ``HashMap<String, Double>`` where the ``String`` is the symbol of each of the reactants and the ``Double`` is how much of that element has. It also takes in a ``boolean`` for weather or not the ``Double`` value in the ``HashMap`` is in mols or grams (``true`` is mols, ``false`` is grams), the symbol of the compound to solve for, and weather to solve for mols or grams (``true`` is mols, ``false`` is grams).