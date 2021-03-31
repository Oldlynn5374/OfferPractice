package Q_12;

public class RouteInMartix {
    private boolean isExist = false;
    // private boolean[][] visited = new boolean[martix.length][martix[0].length];

    public boolean contains(char[][] martix, String route){

        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                backtracking(martix,i,j,0,route);
                if (isExist){
                    return isExist;
                }
            }
        }

        return isExist;
    }

    public void backtracking(char[][] martix, int x, int y, int pos, String route){
        if (pos == route.length()){
            isExist = true;
            return;
        }
        if (x < 0 || y < 0 || x >= martix.length ){
            return;
        }
        if (y >= martix[x].length){
            return;
        }
        if (martix[x][y] == '#' ){
            return;
        }


        char target = route.charAt(pos);
        char value = martix[x][y];
        if (target != value){
            return;
        }

        martix[x][y] = '#';

        backtracking(martix,x+1,y,pos + 1,route);
        backtracking(martix,x-1,y,pos + 1,route);
        backtracking(martix,x,y+1,pos + 1,route);
        backtracking(martix,x,y-1,pos + 1,route);

        martix[x][y] = value;

    }

    public static void main(String[] args) {
        char[][] martix = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        String route = "bfcehsgtb";

        RouteInMartix routeInMartix = new RouteInMartix();
        System.out.println(routeInMartix.contains(martix,route));
    }
}
