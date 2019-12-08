package ru.karvozavr.hldiff.actions

import com.github.gumtreediff.tree.ITree

class MoveAction(node: ITree, val type: String, val newParent: ITree, val position: Int) : HighLevelAction(node) {

    override fun toString(): String {
        return "Move $type to ${newParent.toShortString()} at position $position"
    }
}