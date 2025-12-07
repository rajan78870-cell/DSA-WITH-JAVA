class ArrayWrapper {
    constructor(nums) {
        this.nums = nums;
    }

    // Handles behavior when using + operator
    valueOf() {
        return this.nums.reduce((sum, num) => sum + num, 0);
    }

    // Handles behavior when converting to string
    toString() {
        return `[${this.nums.join(",")}]`;
    }
}
