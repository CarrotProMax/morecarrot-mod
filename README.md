# MoreCarrot Mod

这个模组是可以将萝卜合成压缩萝卜的(最高到三级)，然后还有一个贴图是morecarrotmod的方块，那玩意用稿子敲了会掉700多个金胡萝卜，(可能多也可能少，和时运有关)
金萝卜也可以，这也是我第一个在github上的项目。
（比赛集训摸鱼的时候上传的（嘻嘻））

- 源码仓库：https://github.com/CarrotProMax/MoreCarrotMC-Mod
- 当前版本：`0.1-26.3`（对应 Minecraft 26.3 / Fabric Loader 0.19.5 / Fabric API 0.162.0+26.3 / Java 25）

## 物品与方块

| 名称 | ID |
| --- | --- |
| 卜块 | `morecarrotmod:carrot_block` |
| 二级压缩卜块 | `morecarrotmod:two_level_carrot_block` |
| 三级压缩卜块 | `morecarrotmod:three_level_carrot_block` |
| 金卜块 | `morecarrotmod:gold_carrot_block` |
| 二级压缩金卜块 | `morecarrotmod:two_level_gold_carrot_block` |
| 三级压缩金卜块 | `morecarrotmod:three_level_gold_carrot_block` |
| 神矿 | `morecarrotmod:gold_carrot_block_ore` |
| 萝卜（作者私货贴图） | `morecarrotmod:carrot` |
| 玉足 | `morecarrotmod:ice_ether` |

> 注意：模组 id 是 `morecarrot-mod`，但方块 / 物品的命名空间一直沿用 `morecarrotmod`，这是历史遗留的写法，移植到 26.3 时没有改动，以免旧存档里的方块和物品失效。

## Setup

For setup instructions, please see the [Fabric Documentation page](https://docs.fabricmc.net/develop/getting-started/creating-a-project#setting-up) related to the IDE that you are using.

```bash
./gradlew build      # 打包到 build/libs/
./gradlew runClient  # 启动带模组的客户端
```

## License

This template is available under the CC0 license. Feel free to learn from it and incorporate it in your own projects.
