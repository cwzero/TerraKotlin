package com.liquidforte.terra.rest.representation

import com.liquidforte.terra.model.Mod

data class ModRepresentation(
    val slug: String,
    val id: Long,
    val curseForgeId: Long
) {
    constructor(mod: Mod) : this(mod.slug, mod.id.get(), mod.curseForgeId.get())
}
