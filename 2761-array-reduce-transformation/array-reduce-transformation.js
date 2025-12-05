/**
 * @param {number[]} nums
 * @param {(accum: number, curr: number) => number} fn
 * @param {number} init
 * @return {number}
 */

function reduce(nums, fn, init) {
    let val = init; // Start with initial value

    for (let i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]); // Update accumulator
    }

    return val; // Final result
}
