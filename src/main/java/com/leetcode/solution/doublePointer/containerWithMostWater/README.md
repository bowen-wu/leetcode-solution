## 盛最多水的容器

<https://leetcode.cn/problems/container-with-most-water/>

### 思路

1. Force => 两层 for loop
2. Area = min(h<sub>start</sub>, h<sub>end</sub>) * (end - start)
    - 固定 start 指针，并且 h<sub>start</sub> < h<sub>end</sub> => 无需移动 end，怎么移动都比当前小 => start++
    - 固定 start 指针，并且 h<sub>start</sub> > h<sub>end</sub> => 移动 end，找最大 => end--
    - 固定 end 指针，并且 h<sub>end</sub> < h<sub>start</sub> => 无需移动 start，怎么移动都比当前小 => end--
    - 固定 end 指针，并且 h<sub>end</sub> > h<sub>start</sub> => 移动 start，找最大 => start++
3. 根据上面推断
    1. h<sub>start</sub> < h<sub>end</sub> => start++
    1. h<sub>start</sub> > h<sub>end</sub> => end--

#### 优化

1. 固定 start 指针并且 start++ 时，确保 start 移动到的地方比之前的大才计算面积 => while
