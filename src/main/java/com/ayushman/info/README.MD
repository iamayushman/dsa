## Factors of a number

  ```java
    int counter = 1;
limit =(int)

sqrt(num); // repeats after sqrt
    while(counter <=limit){
        if(num %counter ==0){ // divide to ho raha h

print(counter); // 1 X 36 -> 1 wala part

int other = num / counter; // 1 X 36 -> 36 wala part
        if(other !=counter){

print(other);
        }
                }
counter++;
        }
        }
```

## Is Prime Number

```java
 private static boolean isPrime(int num) {
    int counter = 2, limit = (int) sqrt(num);
    while (counter <= limit) {
        if (num % counter == 0) {
            return false;
        }
        counter++;
    }
    return true;
}
```

## Sieve of eratosthenes

```java
 boolean[] nums = new boolean[num + 1]; 
    Arrays.

fill(nums, true); // make all true

int counter = 2; // below 2 there is no point in case of prime
int limit = (int) sqrt(num);
    while(counter <=limit){
        if(nums[counter]){ // if nums[i] == true
        for(
int i = counter + counter;
i <=num;i +=counter){ // change all factors to false (start from next factor so, `counter + counter` and increase by adding more counter times)
nums[i]=false;
        }
        }
counter++;
        }
        for(
int i = 2;
i<nums.length;i++){ // print all with true value left
        if(nums[i]){

print(i);
      }
              }
              }
```

## Newton Raphson for SQRT

```java
 double root, x = num, tolerance = 0.0001;

 while(true){
root =0.5*(x +num /x);
        if((x -root) <tolerance){
        break;
        }
x =root;
 }
         return(int)root;
```

## GCD

### Method 1

- Iterate over smaller number
- if (num1 % min == 0) and (num2 % min == 0) break
- else min--;

```java
private static int getGCD(int num1, int num2) {
    int min = Math.min(num1, num2);
    while (min > 0) {
        if (num1 % min == 0 && num2 % min == 0) {
            return min;
        }
        min--;
    }
    return 0;
}
```

### Method 2 (shorter/recursion)

```java
private static int euclidGcd(int a, int b) {
    if (a == 0) return b;
    return euclidGcd(b % a, a);
}
```

## LCM

`lcm(a,b) = a*b/gcd(a,b)`>

### [Median of two sorted arrays](https://www.youtube.com/watch?v=2BOgAlmyTkc&list=PLQ7ZAf76c0ZPVdhV1bAjFv0bQc1xHURzE&index=29)

### [Single Element in sorted arrays](https://www.youtube.com/watch?v=f09DayNeigg&list=PLQ7ZAf76c0ZPVdhV1bAjFv0bQc1xHURzE&index=31)


