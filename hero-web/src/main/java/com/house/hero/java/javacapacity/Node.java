package com.house.hero.java.javacapacity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点信息
 * @author jerry
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    Node previous;
    Object obj;
    Node next;
}
