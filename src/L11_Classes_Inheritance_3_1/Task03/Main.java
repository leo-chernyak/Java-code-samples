package L11_Classes_Inheritance_3_1.Task03;

import L11_Classes_Inheritance_3_1.Task03.Orcs.*;

public class Main {
    public static void main(String[] args) {
        Orc ocr1 = new OrcGrunt(50, 100, 500);
        Orc ocr2 = new OrcPeon(50, 100, 500);
        Orc ocr3 = new OrcShaman(50, 100, 500);
        ocr1.Attack();
        ocr2.Attack();
        ocr3.Attack();
    }
}
