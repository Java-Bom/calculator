# 문자열 계산기

## 프로그래밍 요구사항

- 한번의 들여쓰기(indent) 만을 허용한다. 다음 코드는 2번의 들여쓰기가 적용된 경우이다.  
```java
public void foo(){
    for (Foo foo : List<Foo> foos) {
        if (foo == null) {
            throw new IllegalArgumentException();
        }
    }
}    
```
- `else`, `switch ~ case` 예약어를 사용하지 않는다.
- 메서드의 길이는 15라인을 넘어가지 않는다.
- setter를 사용하지 않는다.
