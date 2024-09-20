package com.kotlearn.sharedtopappbar

object CatRepository {

    val cats = listOf(
        Cat(
            id = 1,
            name = "Bengal",
            description = "Bengal Cats are curious and confident with the tameness of a domestic tabby and the beauty of an Asian Leopard Cat. Learn more about Bengals and their playful personality, plus information on their health and how to feed them.",
        ),
        Cat(
            id = 2,
            name = "British Shorthair",
            description = "The British Shorthair is an easygoing feline. She enjoys affection but isn’t needy and dislikes being carried. She’ll follow you from room to room, though, out of curiosity. British Shorthairs aren’t lap cats, but they do enjoy snuggling next to their people on the couch.",
        ),
        Cat(
            id = 3,
            name = "Maine Coon",
            description = "Maine Coon cats are gentle natured and friendly, making them good companions. They are often tenderly playful and curious, making them kitten-like throughout their lives.",
        ),
        Cat(
            id = 4,
            name = "Norwegian Forest",
            description = "The Norwegian Forest Cat is a gentle giant. They’re large and athletic, so you may find them sitting atop the highest point in your home, and they have no qualms about jumping down. Norwegian Forest Cats are fond of their family but are reserved with visitors.",
        ),
        Cat(
            id = 5,
            name = "Persian",
            description = "The docile Persian is a quiet feline who enjoys a calm and relaxing environment. Although she enjoys sitting in her humans’ laps and being pet, she’s just as happy to sit and observe everyone’s comings and goings from afar. Persians are independent and selective in who they show affection to.",
        ),
    )

    fun getById(id: Int) = cats.first { it.id == id }

}