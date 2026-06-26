class Solution:
    '''
    [nums1[0], ..., left1, right1, ..., nums1[-1]]
    [nums2[0], ..., left2, right2, ..., nums2[-1]]
    '''
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums2) < len(nums1): # 确保 nums1 元素较少
            nums1, nums2 = nums2, nums1
        
        tot = len(nums1) + len(nums2)
        half = tot // 2

        l, r = 0, len(nums1)-1
        while True:
            i = l + (r - l) // 2 # 在 nums1 中选取左边 (i+1) 个元素
            j = half - (i+1) - 1 # 在 nums2 中选取左边 half-(i+1) 个元素, 对应的索引需在元素个数上减一

            left1 = nums1[i] if i > -1 else float('-inf')
            right1 = nums1[i+1] if i+1 < len(nums1) else float('inf')
            left2 = nums2[j] if  j > -1 else float('-inf')
            right2 = nums2[j+1] if j+1 < len(nums2) else float('inf')

            if left1 <= right2 and left2 <= right1:
                if tot & 1: # odd
                    return min(right1, right2)
                else: # even
                    return (max(left1, left2) + min(right1, right2)) / 2
            elif left1 > right2: # i 多了, 区间左移
                r = i - 1
            else:
                l = i + 1 # i 少了, 区间右移