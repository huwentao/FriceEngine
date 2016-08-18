package org.frice.game.obj.button

import org.frice.game.event.OnMouseEvent
import org.frice.game.resource.graphics.ColorResource
import org.frice.game.utils.graphics.shape.FShape

/**
 * Created by ice1000 on 2016/8/18.
 *
 * @author ice1000
 * @since v0.3.3
 */
class ShapeButton(
		val shape: FShape, val colorResource: ColorResource,
		override var text: String, override var x: Double,
		override var y: Double, override val width: Double, override val height: Double) : FButton {

	private var bool = false

	override fun getColor() = if (bool) ColorResource(colorResource.color.darker())
	else colorResource

	var onClickListener: OnClickListener? = null

	override fun onClick(e: OnMouseEvent) {
		bool = (containsPoint(e.event.x, e.event.y) && e.type() == OnMouseEvent.MOUSE_PRESSED)
		onClickListener?.onClick()
	}

	interface OnClickListener {
		fun onClick()
	}
}