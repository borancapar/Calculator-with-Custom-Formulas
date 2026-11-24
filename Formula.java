public class Formula {
    double[] sayilar;
    String[] islemler;
    double sonuc;
    public Formula(double[] sayilar, String[] islemler){
        this.sayilar = sayilar;
        this.islemler = islemler;
    }
    public double formulaCalculate(double x) {
        for (int i = 0; i < islemler.length; i++) {
            switch (islemler[i]) {
                case "+": x = x + sayilar[i]; break;
                case "-": x = x - sayilar[i]; break;
                case "*": x = x * sayilar[i]; break;
                case "/": x = x / sayilar[i]; break;

            }
        }
        return x;
    }
//    double calculateFormula(int x) {
//
//    }
}
