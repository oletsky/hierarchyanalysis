package mathcomp.oletsky.hierarchyanalysis;

public class CalculationOfDesiredTau {
    public static void main(String[] args) {
        int max = 30;
        int min = 25;
        int n = 3;
        double ratio = max/(min+0.);
        double tau = SaatiAnalyzer.calculateDesiredConsTau(ratio,n);
        System.out.printf("The tau is %7.5f\n",tau);
    }
}
