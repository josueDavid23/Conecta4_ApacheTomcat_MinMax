package Modelo;
 
import java.util.HashMap;
import java.util.Map;

public  class IA { 
  
   private int nextMoveLocation=-1;
   private  int maxDepth = 9;
   
   // se crea la clase de Inteligencia artificial con la profundidad indicada
   public IA(int profundidad){
       this.maxDepth=profundidad;
    }

   // Es una hash table en la que segun los posibles movimientos en blanco que tenga
   // se retorna el valor ya sea 1*moveScore
   //0, 10* moveScore, 100* move Score, 1000 ,  en caso de no encontrarse al usar 
   // map.get
   int calculateScore(int aiScore, int moreMoves){ 
       int moveScore = 4 - moreMoves; 
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, 0); map.put(1,1*moveScore); map.put(2, 10*moveScore);map.put(3, 100*moveScore);
       int variable= (map.get(aiScore)==null)?1000:map.get(aiScore);
       return variable;
  
   }
   
   // Se evalua el tablero de forma horizontal derecha si encuentre una ficha de color rojo se le suma al 
  // contador de la aiscore y si encuentra una de color blanco se le suma a la cantidad de espacios en blanco
   // Recibe la cantidad movimientos consecutivos del IA, cantidad de espacios en blanco que serian posibles movimientos
   // el i y j actual y el arreglo correspondiente a la suma de i y j para realizar las respectivas sumas
   public int[] validaEval(int aiScore,int blanks, Tablero b, int i, int j, int[] filas,int[] cols){
        OUTER:
            for (int k=1; k<filas.length; ++k) {
                switch (b.getMatriz()[i+filas[k]][j+cols[k]].getColor()) {   // aqui
                case 1:aiScore++; break;
                case 2:aiScore=0; blanks = 0; break OUTER;
                default:blanks++; break;}}
        int arreglo[] = {aiScore,blanks};
       return arreglo;
   }
   // Funcion en la cual se revisa la cantidad de espacios en blanco que existan
   // los cuales determinaran los posibles movimientos a realizar por la IA, al encontrar una ficha 
   // del jugador 2 realiza un break del ciclo para salir
   public int validaEvalDos(Tablero b, int moreMoves, int[]filas,int[]cols,int i, int j){
       for(int c=1;c<filas.length;++c){ // seria {0,-1,-2,-3} [0,-1,-2,-3]
            int column = j+cols[c], row = i+filas[c];
            OUTER_5:
            for (int m = row; m<=5; ++m) {
                switch (b.getMatriz()[m][column].getColor()) {  //1
                    case 0: moreMoves++; break;
                    case 1:; break;
                    default: break OUTER_5;
                }
            }
        }
       return moreMoves;
   }
   // Se evalua si existen espacios disponibles para mover la ficha , en caso de que si se procede
   // a sumarle al contador y luego retornar esta cantidad de espacios actualizados, el ciclo hace un break 
   // 
   public int validaEvalTres(Tablero b,int moreMoves,int j, int i,int[]cols){
       for(int c=1;c<cols.length;++c){  /// este return more moves 2
            int column = j+cols[c];   // j+c
            for(int m=i; m<= 5;m++){
                if(b.getMatriz()[m][column].getColor()==0)moreMoves++;
                else break; }  }
       return moreMoves;
   }

   // Se evalua el tablero 
   public int evaluateBoard(Tablero b){
     
       int aiScore=1;
       int score=0;
       int blanks = 0;
       int k=0, moreMoves=0;
       for(int i=5;i>=0;--i){
           for(int j=0;j<=6;++j){
               
               if(b.getMatriz()[i][j].getColor()==0 || b.getMatriz()[i][j].getColor()==2) continue; 
               
               // se evalua el tablero de forma horizontal derecha si encuentre una ficha de color rojo se le suma al 
               // contador de la aiscore y si encuentra una de color blanco se le suma a la cantidad de espacios en blanco
               if(j<=3){ 
                   int[]filas={0,0,0,0}; int [] cols={0,1,2,3};
                   int arreglo[]= validaEval(aiScore,blanks, b, i, j, filas,cols);
                   blanks=arreglo[1]; aiScore=arreglo[0];
                    
                   moreMoves = 0; 
                   int [] colsD={0,1,2,3};
                   // si hay espacios en blanco en esa jugada recorre alrededore para ver que otros espacios aledanos hay 
                   //posibles para realizar el movimiento va de 3 en 3 y recorre de la fila hacia arriga,
                   //sirve para ver que tantos movimientos quedan en el tablero
                   // entre menos quedan mas dificil es para el usuario ganar
                   if(blanks>0) 
                       moreMoves=validaEvalTres(b,moreMoves,j,i,colsD);   // da la nueva cantidad de posibles movimientos en blanco       
                   if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);// se calcula el puntaje de acuerdo a la cantidad movimientos en blanco
                   aiScore=1; blanks = 0;
               } 
               
               // se evalua el tablero de forma vertical si encuentre una ficha de color rojo se le suma al 
               // contador de la aiscore , si encuentra una ficha de color del jugador 2 reinicia el contador de la 
               // inteligencia artificial
               if(i>=3){
                   for(k=1;k<4;++k){
                       if(b.getMatriz()[i-k][j].getColor()==1)aiScore++;
                       else if(b.getMatriz()[i-k][j].getColor()==2){aiScore=0;break;}   
                   } 
                   
                // se evalua el tablero de forma vertical si encuentre una ficha de color blanco se le suma al 
               // contador de posibles movimientos , si no es asi realiza un break y sale del ciclo
                   moreMoves = 0; 
                   if(aiScore>0){
                       int column = j;
                       for(int m=i-k+1; m<=i-1;m++){
                        if(b.getMatriz()[m][column].getColor()==0)moreMoves++;
                           else break;
                       }  
                   }
                   if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
                   aiScore=1;   blanks = 0;
               }
              // se evalua el tablero de forma horizontal izquierda si encuentre una ficha de color rojo se le suma al 
               // contador de la aiscore y si encuentra una de color blanco se le suma a la cantidad de espacios en blanco
               if(j>=3){
                   int[]filas={0,0,0,0}; int [] cols={0,-1,-2,-3};
                   int arreglo[]= validaEval(aiScore,blanks, b, i, j, filas,cols);
                   blanks=arreglo[1]; aiScore=arreglo[0];
                   moreMoves=0;
                   if(blanks>0)
                       moreMoves=validaEvalTres(b,moreMoves,j,i,cols);       
                                         
                   if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
                   aiScore=1; 
                   blanks = 0;
               }
               // se evalua el tablero de forma diagonal derecha superior si encuentre una ficha de color rojo se le suma al 
               // contador de la aiscore y si encuentra una de color blanco se le suma a la cantidad de espacios en blanco
               if(j<=3 && i>=3){  //  i-k j +k
                   int[]filas={0,-1,-2,-3}; int [] cols={0,1,2,3};
                   int arreglo[]= validaEval(aiScore,blanks, b, i, j, filas,cols);
                   blanks=arreglo[1]; aiScore=arreglo[0];
                   moreMoves=0;
                   if(blanks>0){  // j+c{0,1,2,3}  i-c {0,-1,-2,-3}
                       int []filasA={0,-1,-2,-3}; int [] colsA={0,1,2,3};
                       moreMoves= validaEvalDos(b, moreMoves, filasA,colsA,i, j); // revisa cantidad espacios en blanco posibles movimientos
                       if(moreMoves!=0) score += calculateScore(aiScore, moreMoves);
                       aiScore=1;
                       blanks = 0;
                   }
               }             
               // se evalua el tablero de forma diagonal izquierdaa inferior si encuentre una ficha de color rojo se le suma al 
               // contador de la aiscore y si encuentra una de color blanco se le suma a la cantidad de espacios en blanco
               
               if(i>=3 && j>=3){  // i-k j-k
                   int[]filas={0,-1,-2,-3}; int [] cols={0,-1,-2,-3};
                   int arreglo[]= validaEval(aiScore,blanks, b, i, j, filas,cols);
                   blanks=arreglo[1]; aiScore=arreglo[0];
                   moreMoves=0;
                   if(blanks>0){
                       int filasA[]={0,-1,-2,-3}; int colsA[]={0,-1,-2,-3};
                       moreMoves= validaEvalDos(b, moreMoves, filasA,colsA,i, j);
                     
                       if(moreMoves!=0) score += calculateScore(aiScore, moreMoves); // calcula el puntaje de acuerdo 
                       aiScore=1;                                                    // a la cantidad de espacios en blanco y movimientos consecutivos de IA
                       blanks = 0;
                   }
               } 
           }
       }
       return score; }
   // Funcion minimax con poda alpa beta 
   // Recibe la profundidad actual por lo cual va recorriendo
   // Quien sigue haciendo la jugada
   // El alpha y beta que se quiere maximizar y minimizar respectivamente
   public int minimax(int depth, int turn, int alpha, int beta, Juego b){ // minimax alpha es minimo beta max
       if(beta<=alpha){if(turn == 1) return Integer.MAX_VALUE; else return Integer.MIN_VALUE; }
       int gameResult = b.gameResult();// VALIDA GANE 
       switch (gameResult) {
           case 1:
               return Integer.MAX_VALUE/2; // game result gano IA
           case 2:
               return Integer.MIN_VALUE/2; //GANO JUGADOR
           case 0:
               return 0;  // EMPATE
           default:
               break;
       }
       // VALIDA si ya llegue a la profundidad maxima establecida
       if(depth==maxDepth)return evaluateBoard(b.getTablero());
       int maxScore=Integer.MIN_VALUE, minScore = Integer.MAX_VALUE;
       
       for(int j=0;j<=b.getTablero().getFilas();++j){
           int currentScore = 0;
           if(!b.getTablero().isLegalMove(j)) continue; 
           if(turn==1){ // turno del IA
                   b.getTablero().placeMove(j, 1);
                   currentScore = minimax(depth+1, 2, alpha, beta,b); // se le suma uno a la profundidad aumentando a la profundidad
                   if(depth==0){  // ya se ha llegado a la profundidad 0 por lo que imprime a todo los resultados anteriores
                       System.out.println("Score for location "+j+" = "+currentScore);
                       if(currentScore > maxScore)nextMoveLocation = j; 
                       if(currentScore == Integer.MAX_VALUE/2){b.getTablero().undoMove(j);break;}}
                   maxScore = Math.max(currentScore, maxScore);
                   alpha = Math.max(currentScore, alpha);  } 
           else if(turn==2){ // turno del jugador
                   b.getTablero().placeMove(j, 2);
                   currentScore = minimax(depth+1, 1, alpha, beta,b); // se le suma uno a la profundidad aumentando la profundidad
                   minScore = Math.min(currentScore, minScore);
                  beta = Math.min(currentScore, beta); 
           }  
           b.getTablero().undoMove(j); 
           if(currentScore == Integer.MAX_VALUE || currentScore == Integer.MIN_VALUE) break; // realiza poda 
       }   return turn==1?maxScore:minScore;
   }
   
   // Inicializa variables y llama a la funcion encargada de realizar 
   public int getAIMove(Juego b){  
       nextMoveLocation = -1;
       minimax(0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE,b);
       return nextMoveLocation;
   }
}

