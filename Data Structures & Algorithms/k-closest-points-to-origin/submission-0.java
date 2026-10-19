class Solution {

    class PointWithDist{

        double dist;
        int px;
        int py;
        
        PointWithDist(double dist, int x, int y){
            this.dist = dist;
            this.px = x;
            this.py = y;
        }

    }

    PointWithDist findDistanceFromOrigin(int x, int y){
        int innerExp = (Math.abs(x - 0) * Math.abs(x - 0)) + (Math.abs(y - 0) * Math.abs(y - 0));
        return new PointWithDist(Math.sqrt(innerExp), x, y);
    }


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointWithDist> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(b.dist, a.dist)
        );

        for(int[] point : points){
            PointWithDist pointWithDist = findDistanceFromOrigin(point[0], point[1]);
            maxHeap.offer(pointWithDist);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            PointWithDist curr = maxHeap.poll();
            result[i][0] = curr.px;
            result[i][1] = curr.py;
            i++;
        }

        return result;
    }
}
