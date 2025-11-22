from typing import List

class Solution:
    
    def twoSum_bruteforce(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]

    # Optimized O(n) using hashmap
    def twoSum_optimized(self, nums: List[int], target: int) -> List[int]:
        seen = {}  # value -> index
        for i, num in enumerate(nums):
            comp = target - num
            if comp in seen:
                return [seen[comp], i]
            seen[num] = i

    # Unified method with option to choose approach
    def twoSum(self, nums: List[int], target: int, method: str = "optimized") -> List[int]:
        if method == "bruteforce":
            return self.twoSum_bruteforce(nums, target)
        else:
            return self.twoSum_optimized(nums, target)


# Example usage
if __name__ == "__main__":
    sol = Solution()

    nums1, target1 = [2, 7, 11, 15], 9
    print("Brute force:", sol.twoSum(nums1, target1, method="bruteforce"))   # [0, 1]
    print("Optimized:", sol.twoSum(nums1, target1))                          # [0, 1]

    nums2, target2 = [3, 2, 4], 6
    print("Brute force:", sol.twoSum(nums2, target2, method="bruteforce"))   # [1, 2]
    print("Optimized:", sol.twoSum(nums2, target2))                          # [1, 2]

    nums3, target3 = [3, 3], 6
    print("Brute force:", sol.twoSum(nums3, target3, method="bruteforce"))   # [0, 1]
    print("Optimized:", sol.twoSum(nums3, target3))                          # [0, 1]
