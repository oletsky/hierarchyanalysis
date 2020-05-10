package mathcomp.oletsky.hierarchyanalysis;

import mathcomp.oletsky.mathhelper.VectMatr;

import static mathcomp.oletsky.hierarchyanalysis.SaatiAnalyzer.obtainDoubleComparisonMatrix;

/**
 * @author O.Oletsky
 * Illustates how adding of a new outsider alternative
 * can change preference between two others
 */

public class ExtraVariantChangesPreference {
    public static void main(String[] args) {
        //Initial comparisons
        int[][] comparInitial = {
                {1}
        };
        double tau=1.1;

        double[] vectInitial=SaatiAnalyzer.calculateSaatiVectorByIntPreferences
                (comparInitial,tau);
        System.out.println("Initial preferences:");
        VectMatr.defaultOutputVector(vectInitial);

        //Comparisons after adding
        int[][] afterAddCompar = {
                {1, 1},
                    {4}
        };

        double[] vectAfterAdd=SaatiAnalyzer.calculateSaatiVectorByIntPreferences
                (afterAddCompar,tau);
        System.out.println("Preferences after adding:");
        VectMatr.defaultOutputVector(vectAfterAdd);
        double[][] dMatr = obtainDoubleComparisonMatrix(afterAddCompar,tau);
        System.out.printf("Consistency: %8.4f\n",
                SaatiAnalyzer.calculateConsistency(vectAfterAdd,
                        dMatr));

    }
}
