class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        ss = sum(nums)
        if ss & 1 == 1:
            return False
        
        s = ss >> 1
        n = len(nums)
        dp = [[0 for _ in range(n)] for _ in range(s+1)]
        # dp[i][j]: sum=i, choose in 0, ..., j

        for i in range(nums[0], s+1):
            dp[i][0] = nums[0]
        
        for j in range(1, n):
            for i in range(0, s+1):
                dp[i][j] = max(
                    dp[i][j-1],
                    0 if i-nums[j] < 0 else dp[i-nums[j]][j-1] + nums[j],
                )
        
        return dp[s][n-1] * 2 == ss
