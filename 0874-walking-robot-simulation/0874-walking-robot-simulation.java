class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obstacleSet.add(key);
        }

        int x = 0;
        int y = 0;
        int maxDistance = 0;

        // Initially pointing North
        int[] dir = {0, 1}; // North

        // Process each command
        for (int i = 0; i < commands.length; i++) {
            
            if (commands[i] == -2) { // turn left 90 degrees
                dir = new int[]{-dir[1], dir[0]};
                continue;
            }
            
            if (commands[i] == -1) { // turn right 90 degrees
                dir = new int[]{dir[1], -dir[0]};
                continue;
            }
            
            for (int step = 0; step < commands[i]; step++) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                String nextKey = newX + "_" + newY;

                if (obstacleSet.contains(nextKey)) {
                    break;
                }

                x = newX;
                y = newY;
            }

            maxDistance = Math.max(maxDistance, x * x + y * y);
        }

        return maxDistance;
    }
}