package mathcomp.oletsky.hierarchyanalysis;

import mathcomp.oletsky.mathhelper.VectMatr;

import static mathcomp.oletsky.hierarchyanalysis.SaatiAnalyzer.*;

public class PairComparisons {
    public static void main(String[] args) {
        int[][] matr={
                {1, 2},
                {1}

        };
        double tau=1.2;
        double max=30;
        double[] values = calculateSaatiVectorByIntPreferences(matr,tau);
        System.out.println("Eigenvector:");
        VectMatr.defaultOutputVector(values);
        System.out.println("Real comparison matrix:");
        double[][] dMatr = obtainDoubleComparisonMatrix(matr,tau);
        VectMatr.defaultOutputMatrix(dMatr);
        System.out.printf("Consistency: %8.4f\n",
                SaatiAnalyzer.calculateConsistency(values,
                        dMatr));
        System.out.println("Recommended grades:");
        double[] marks = getMarks(values,max);
        VectMatr.defaultOutputVector(marks);

    }


}
