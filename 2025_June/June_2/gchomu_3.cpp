#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
int n, m, minTurn=987654321;
int dx[]={0, 0, -1, 1}, dy[]={-1, 1, 0, 0};
int startRed[2], startBlue[2], endRed[2], endBlue[2];
bool visitedRed[4][4], visitedBlue[4][4];

//초기값 설정
void init(vector<vector<int>> maze){
    n = maze.size();
    m = maze[0].size();
    for(int i=0; i<n; ++i){
        for(int j=0; j<m; ++j){
            int cur= maze[i][j];
            if(cur==1){
                startRed[0]=i;
                startRed[1]=j;
            }else if(cur==2){
                startBlue[0]=i;
                startBlue[1]=j;
            }else if(cur==3){
                endRed[0]=i;
                endRed[1]=j;
            }else if(cur==4){
                endBlue[0]=i;
                endBlue[1]=j;
            }else if(cur==5){
                visitedRed[i][j]=true;
                visitedBlue[i][j]=true;
            }
        }
    }
}

//red: 0, blue: 1
bool isOutRange(int r, int c, int color){
    if(color==0){
        return (r<0 || r>=n || c<0 || c>=m || visitedRed[r][c]); 
    }else{
        return (r<0 || r>=n || c<0 || c>=m || visitedBlue[r][c]);
    }
}

void dfsRedFirst(int redR, int redC, int blueR, int blueC, int depth){
    if(redR==endRed[0] && redC==endRed[1] && blueR==endBlue[0] && blueC==endBlue[1]){

        minTurn = min(minTurn, depth);
        return;
    }
    visitedRed[redR][redC]=true;
    visitedBlue[blueR][blueC]=true;
    
    for(int i=0; i<4; ++i){
        int nRedR = redR + dx[i], nRedC = redC + dy[i];
        
        if(redR==endRed[0] && redC==endRed[1]){
            nRedR= endRed[0];
            nRedC= endRed[1];
        }else if(isOutRange(nRedR, nRedC, 0)){
            continue;
        }
        for(int j=0; j<4; ++j){
            int nBlueR = blueR + dx[j], nBlueC = blueC + dy[j];
            //범위를 벗어나거나, 수레가 겹치는 위치, 혹은 교환되는 위치면 continue
            if(blueR==endBlue[0] && blueC==endBlue[1]){
                nBlueR= endBlue[0];
                nBlueC= endBlue[1];
            }
            if(isOutRange(nBlueR, nBlueC, 1) || (nBlueR==nRedR && nBlueC==nRedC) || (redR==nBlueR&&redC==nBlueC&&blueR==nRedR&&blueC==nRedC))
                continue;


            dfsRedFirst(nRedR, nRedC, nBlueR, nBlueC, depth+1);
        }
    }
    
    
    visitedRed[redR][redC]=false;
    visitedBlue[blueR][blueC]=false;
}


void dfsBlueFirst(int redR, int redC, int blueR, int blueC, int depth){    
    if(redR==endRed[0] && redC==endRed[1] && blueR==endBlue[0] && blueC==endBlue[1]){
        minTurn = min(minTurn, depth);
        return;
    }
    visitedRed[redR][redC]=true;
    visitedBlue[blueR][blueC]=true;
    
    for(int i=0; i<4; ++i){        
        int nBlueR = blueR + dx[i], nBlueC = blueC + dy[i];

        //범위를 벗어나거나, 수레가 겹치는 위치면 continue
        

        if(blueR==endBlue[0] && blueC==endBlue[1]){
            nBlueR= endBlue[0];
            nBlueC= endBlue[1];
        }else if(isOutRange(nBlueR, nBlueC, 1)){
            continue;   
        }

    
        for(int j=0; j<4; ++j){
            int nRedR = redR + dx[j], nRedC = redC + dy[j];
            if(redR==endRed[0] && redC==endRed[1]){
                nRedR= endRed[0];
                nRedC= endRed[1];
            }
            //범위를 벗어나거나, 수레가 겹치는 위치면 continue
            if(isOutRange(nRedR, nRedC, 0) || (nBlueR==nRedR && nBlueC==nRedC)|| (redR==nBlueR&&redC==nBlueC&&blueR==nRedR&&blueC==nRedC))
                continue;


            dfsBlueFirst(nRedR, nRedC, nBlueR, nBlueC, depth+1);
        }
    }
    
    
    visitedRed[redR][redC]=false;
    visitedBlue[blueR][blueC]=false;
}

int solution(vector<vector<int>> maze) {
    init(maze);
    dfsRedFirst(startRed[0], startRed[1], startBlue[0], startBlue[1], 0);
    dfsBlueFirst(startRed[0], startRed[1], startBlue[0], startBlue[1], 0);
    if(minTurn==987654321)
        minTurn=0;
    return minTurn;
}
