package e2;

public class Slopes {

    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {

        int contador1 = 0, trees = 0, fila = 0, col = 0;

        for (int i = 0; i < slopeMap.length; i++){
            for (int j = 0; j < slopeMap[i].length; j++){
                if (slopeMap[i].length != slopeMap.length || (slopeMap[i][j] != '.' && slopeMap[i][j] != '#')){
                    contador1++;
                }
            }
        }

        if(contador1 != 0 || right >= slopeMap[0].length || down >= slopeMap.length || right < 1 || down < 1){
            throw new IllegalArgumentException();
        } else {
            int maxFila = slopeMap.length, maxCol = slopeMap[0].length;

            while (fila <= maxFila -1){

                for (int i = 0; i < right; i++){
                    col++;
                    if (col == maxCol){
                        col = 0;
                    }
                    if (col < maxCol && slopeMap[fila][col] == '#'){
                        trees++;
                    }
                }
                if (fila < maxFila - 1){
                    for (int i = 0; i < down; i++){
                        fila++;
                        if (fila < maxFila && col<maxCol && slopeMap[fila][col] == '#'){
                            trees++;
                        }
                    }
                } else {
                    fila++;
                }
            }

        }
        return trees;
    }

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {

        int contador1 = 0, trees = 0, fila = 0, col = 0;

        for (int i = 0; i < slopeMap.length; i++){
            for (int j = 0; j < slopeMap[i].length; j++){

                if (slopeMap[i].length != slopeMap.length || (slopeMap[i][j] != '.' && slopeMap[i][j] != '#')){
                    contador1++;
                }
            }

        }

        if(contador1 != 0 || right >= slopeMap[0].length || down >= slopeMap.length || right < 1 || down < 1){
            throw new IllegalArgumentException();
        } else {
            int maxFila = slopeMap.length, maxCol = slopeMap[0].length;

            while (fila <= maxFila - 1){

                for (int i = 0; i < right; i++){
                    col++;
                    if (col == maxCol){
                        col = 0;
                    }
                }

                if (fila < maxFila - 1){
                    for (int i = 0; i < down; i++){
                        fila++;
                    }

                    if (fila < maxFila && col<maxCol && slopeMap[fila][col] == '#'){
                        trees++;
                    }

                } else {
                    fila++;
                }

            }

        }
        return trees;

    }

}
