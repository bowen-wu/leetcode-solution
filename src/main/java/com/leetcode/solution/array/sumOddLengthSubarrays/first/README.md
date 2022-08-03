## 时间复杂度

```
while (currentOdd < arr.length) {
    int start = 0;
    while (start + currentOdd < arr.length) {
        result += prefixSum[start + currentOdd + 1] - prefixSum[start];
        start++;
    }
    currentOdd += 2;
}
```

- $\sum_{i=3}^n$ * $\sum_{j=0}^{n-i}$ * O(1)
- $\sum_{i=3}^n$ * (n - i)
- (n-3) + (n-4) + (n-5) + ... + 1 => n(a<sub>1</sub> + a<sub>n</sub>)/2
- O(n^2)
