package mathcomp.oletsky.hierarchyanalysis;

import mathcomp.oletsky.mathhelper.VectMatr;

public class SaatiAnalyzer {
    public static double[] getSaatiVector(double[][] m) {
        int n = m.length;
        double[] res = new double[n];
        double[] eig = VectMatr.getMainEigenVector(m);
        res = VectMatr.normalizeVectorBySum(eig);
        return res;
    }

    public static double[] getValuesByGeom(double[][] m) {
        int n = m.length;
        double[] res = new double[n];
        for (int i=0; i<n; i++) {
            res[i]=VectMatr.calculateGeomAverage(m[i]);
        }
        double[] normRes = VectMatr.normalizeVectorBySum(res);
        return normRes;

    }

    public static double[] getNotNormalizedVector(double[][] m) {
        int n = m.length;
        double[] eig = VectMatr.getMainEigenVector(m);
        return eig;
    }

    public static double[] calculateSaatiVectorByIntPreferences(
            int[][] matr,
            double tau

    ){
        double[][] compar= obtainDoubleComparisonMatrix(matr, tau);
        double[] vect = getSaatiVector(compar);
        return vect;
    }

    public static double[][] obtainDoubleComparisonMatrix(
            int[][] rawMatrix,
            double tau
    ){
        int n = rawMatrix.length+1;
        if (n!=rawMatrix[0].length+1)
            throw new IllegalArgumentException("Wrong dimensions");
        double[][] res = new double[n][n];
        for (int i = 0; i <n ; i++) {
            res[i][i]=1.;
            for (int j = i+1; j <n ; j++) {

                res[i][j]=translate(rawMatrix[i][j-i-1],tau);
                res[j][i]=1./translate(rawMatrix[i][j-i-1],tau);
            }
        }
        return res;
    }

    public static double[] getMarks(double[] vect,
                             double max) {
        double[] v = new double[vect.length];
        double m = VectMatr.getMaxValue(vect);
        for (int i = 0; i <vect.length ; i++) {
            v[i]=vect[i]/m*max;
        }
        return v;
    }

    public static double translate(int c, double tau) {
        return Math.pow(tau, c);
    }


    public static double calculateConsistency(double[] v,
                                              double[][] matr) {
        int n = matr.length;
        double[] r=VectMatr.rightMultiply(matr,v);
        double eigenValue=r[0]/v[0];
        double cons = (eigenValue-n)/(n-1);
        return cons;
    }

    public static double calculateDesiredConsTau(double desiredRatio,
                                                 int n) {
        double tau=Math.pow(desiredRatio, 1./(n-1.));
        return tau;
    }

}
