1	C
2	B
3	D
4	C
5	C
6	D
7	C
8	C
9	C
10	C

Concept Questions

Q1. Head vs tail insertion Inserting at the head only needs a new node whose next points to the old head, then the head reference is updated. That is a fixed number of steps, so O(1). With only a head reference, reaching the tail means following next links through all n nodes, so tail insertion is O(n). If we also keep a tail reference, we can attach the new node directly to tail.next and move tail forward, with no traversal. That makes tail insertion O(1).

Q2. Deleting a node: singly vs doubly To delete a node in a singly linked list, the previous node's next must be changed to skip it. A node has no link back to its predecessor, so we must traverse from the head to find it (or already hold it). In a doubly linked list each node stores prev, so the node itself knows its neighbours. We can set node.prev.next = node.next and node.next.prev = node.prev directly. With a direct reference to the node, deletion is O(1) and needs no search.

Q3. Linked list vs array traversal speed Array elements sit in contiguous memory. When the CPU loads one element, it fetches a whole cache line containing the next several elements, so later accesses are cache hits, and hardware prefetching works well. Linked list nodes are allocated separately and can be scattered across memory. Each next hop is likely to land in a different cache line, causing frequent cache misses, which are far slower than hits. Pointer chasing also makes each access depend on the previous one, which prevents prefetching and pipelining. Both are O(n), but the constant factor is much higher for linked lists.

Q4. Merging sorted lists: relinking vs copying When merging two linked lists, we just rewire the next pointers of the existing nodes into one sorted chain. No new nodes or data are created, so extra space is O(1). Merging two sorted arrays normally copies all elements into a new array of size m+n, so extra space is O(m+n). Relinking is therefore more memory efficient.

Q5. Role of next and the end condition The next pointer links each node to its successor, so traversal starts at the head and repeatedly moves current = current.next. The loop condition is current != null, and the end of the list has been reached when current becomes null. This is reliable because the last node's next is always null by construction. No valid node ever has a null reference as its successor, so null can only mean there are no more nodes.