package org.frice.game.utils.time

import org.frice.game.platform.FriceClock
import org.frice.game.utils.misc.unless

/**
 * Created by ice1000 on 2016/10/16.
 *
 * @author ice1000
 */
object Clock : FriceClock {
	var started = true
		internal set
	var startTicks = System.currentTimeMillis()
		internal set
	var pauseTicks = startTicks
		internal set

	override val current: Long
		get() = if (started) System.currentTimeMillis() - startTicks else pauseTicks - startTicks

	override fun init() {
		startTicks = System.currentTimeMillis()
		started = true
	}

	override fun resume() {
		if (started) return
		startTicks += System.currentTimeMillis() - pauseTicks
		started = true
	}

	override fun pause() {
		unless(started) {
			return
		}
		pauseTicks = System.currentTimeMillis()
		started = false
	}
}