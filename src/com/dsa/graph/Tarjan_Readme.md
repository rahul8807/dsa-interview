# Comparison of Tarjan's Algorithm, Bridge Finding, and Articulation Point Detection

This document compares and contrasts three graph algorithms: Tarjan's algorithm for finding Strongly Connected Components (SCCs), bridge finding, and articulation point detection.

## Tabular Comparison

| Feature           | Tarjan's Algorithm (SCCs) | Bridge Finding                                   | Articulation Point Detection                       |
| ----------------- | --------------------------- | ------------------------------------------------- | -------------------------------------------------- |
| **Goal** | Find Strongly Connected Components | Find bridges (edges whose removal increases connected components) | Find articulation points (vertices whose removal increases connected components) |
| **DFS Use** | Yes                         | Yes                                               | Yes                                                |
| **`low` Value** | Lowest `discovery` reachable through tree edges and at most 1 back edge | Lowest `discovery` reachable (excluding parent-child edge) | Lowest `discovery` reachable through tree edges and at most 1 back edge |
| **Stack Usage** | Essential (for SCC formation) | Not needed                                        | Not needed                                         |
| **Condition** | `low[u] == discovery[u]`   | `low[v] > discovery[u]` (where `(u, v)` is the edge) | Root: 2+ children; Non-root: `low[v] >= discovery[u]` (where `v` is a child of `u`) |
| **Parent Tracking** | Not needed                  | Essential (to exclude parent-child edge)          | Essential (to exclude parent-child edge)           |
| **Back Edges** | Very important               | Very important, except parent-child edge           | Very important, except parent-child edge           |
| **Output** | List of SCCs (lists of nodes) | List of bridge edges                             | List of articulation points                       |
| **Root Case** | No special handling           | No special handling                               | Special handling (2+ children)                     |
| **Example** | Grouping circular dependencies | Finding critical network links                   | Identifying critical network nodes                 |

## Key Takeaways

* **Shared Foundation:** All three algorithms use Depth-First Search (DFS) and the concept of "low-link" values.
* **Distinct Goals:** Their objectives are different, leading to variations in implementation.
* **Condition Differences:** The specific conditions used to identify SCCs, bridges, and articulation points are unique.
* **Stack vs. No Stack:** Tarjan's algorithm utilizes a stack for SCC formation, while bridge and articulation point detection do not.
* **Parent Tracking:** Bridge and articulation point detection require tracking the parent node to exclude the parent-child edge from consideration.
* **Root Case:** Articulation point detection has a special case for the root node of the DFS tree.

## Algorithm Specifics

### Tarjan's Algorithm (Strongly Connected Components)

* Finds groups of nodes where every node is reachable from every other node within the group.
* Uses a stack to track nodes in the current DFS path.
* An SCC is found when `low[u] == discovery[u]`.

### Bridge Finding

* Finds edges that, if removed, would increase the number of connected components in the graph.
* Uses `low` values to determine if a node can reach an ancestor without using the current edge.
* An edge `(parent, u)` is a bridge if `low[u] > discovery[parent]`.

### Articulation Point Detection

* Finds nodes that, if removed, would increase the number of connected components in the graph.
* Uses `low` values to determine if a node can reach an ancestor without using the path through itself.
* Root node: An articulation point if it has more than one child.
* Non-root node: An articulation point if there's a child `v` of `u` such that `low[v] >= discovery[u]`.