package ru.karvozavr.hldiff.actions

import com.github.gumtreediff.actions.model.*
import com.github.gumtreediff.tree.ITree
import com.github.gumtreediff.tree.TreeContext
import ru.karvozavr.hldiff.language.LanguageInfo

abstract class HighLevelAction(val node: ITree) {

    companion object {

        fun of(lowLevelAction: Action, languageInfo: LanguageInfo, isPartial: Boolean = false): HighLevelAction {
            val node = lowLevelAction.node

            val nodeTypeString = languageInfo.getTypeName(node)
            val actionObjectType = if (isPartial) "$nodeTypeString Partial" else nodeTypeString

            return when (lowLevelAction) {
                is Delete -> DeleteAction(node, actionObjectType)
                is Update -> TODO()
                is Move -> MoveAction(node, actionObjectType, languageInfo.getTypeName(lowLevelAction.parent), lowLevelAction.position)
                is Insert -> InsertAction(node, actionObjectType, languageInfo.getTypeName(lowLevelAction.parent), lowLevelAction.position)
                else -> throw RuntimeException("Low-level action of unknown type - ${lowLevelAction.javaClass}.")
            }
        }

        fun prettyPrint(action: HighLevelAction, before: String, after: String): String {
            return when (action) {
                is InsertAction -> action.toString()
                is DeleteAction -> action.toString()
                is UpdateAction -> before.substring(action.node.pos, action.node.pos + 15) + "...    " + action.toString()
                is MoveAction -> action.toString()
                else -> throw RuntimeException("Unknown high-level action type")
            }
        }
    }
}