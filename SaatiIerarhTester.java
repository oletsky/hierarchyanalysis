package mathcomp.oletsky.hierarchyanalysis;

import mathcomp.oletsky.mathhelper.VectMatr;

public class SaatiIerarhTester {
    public static void main(String[] args) {
        double tauObj=1.5;
        double tauCrit=1.2;
        //Comparisons of objects by criteria
        double[][][] objCritMatr=
                {
                        {
                                //First criterion
                                {1., tauObj},
                                {1./tauObj, 1.},

                        } ,
                        {
                                //Second criterion
                                {1., 1./tauObj},
                                {tauObj, 1.},

                        } ,
                        {
                                //Third criteria
                                {1., 1.},
                                {1., 1.},
                        }
                };
        int m=objCritMatr.length;
        System.out.println("Number of criteria: "+m);
        int n=objCritMatr[0].length;
        System.out.println("Number of objects: "+n);
        System.out.println("-------------------");

        double[][] objCritSaati=new double[m][n];

        for (int i = 0; i <m ; i++) {
            objCritSaati[i]= SaatiAnalyzer.getSaatiVector(objCritMatr[i]);

        }

        System.out.println("Comparisons of objects by criteria:");
        VectMatr.defaultOutputMatrix(objCritSaati);
        System.out.println("-------------------");

        //Comparisons of criteria

        double[][] critCompMatrix = {
                {1.,    1./tauCrit,    tauCrit*tauCrit} ,
                {tauCrit, 1., tauCrit*tauCrit},
                {1./(tauCrit*tauCrit),1./(tauCrit*tauCrit),1.}
        };
        double[] critCoeffs=SaatiAnalyzer.getSaatiVector(critCompMatrix);
        System.out.println("Coefficients of criteria:");
        VectMatr.defaultOutputVector(critCoeffs);
        System.out.println("------------------------");

        double[] objValues=VectMatr.leftMultiply(critCoeffs,objCritSaati);
        System.out.println("Values of objects:");
        VectMatr.defaultOutputVector(objValues);


    }
}
