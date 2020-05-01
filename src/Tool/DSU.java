package Tool;

class DSU
{
    int[] parent;
    //记录总共的数量
    int number;
    public DSU(int N)
    {
        parent = new int[N];
        number = N;
        for(int i =0;i<N;i++)
        {
            parent[i] = i;
        }
    }

    public int find(int x)
    {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x,int y){
        number--;
        parent[find(x)] = find(y);
    }
}