var app = new Vue({
    el: "#menu",
    data: {},
    methods: {
        getNodes: function () {
            const that = this
            $.ajax({
                url: "menu/get/nodes.json",
                type: "get",
                data: {},
                dataType: "json",
                async: false,
                success: function (response) {
                    console.log(response.data);
                    that.generateTree(response.data);
                },
                error: function (response) {
                    console.log(response);
                }
            })
        },

        generateTree: function (nodes) {
            var zTreeObj;
            // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）

            var setting = {
                data: {
                    key: {
                        name: "mName",
                        url: "mUrl",
                    }
                }
            };
            // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）

            /*var nodes = [
                {name: "父节点1", children: [
                        {name: "子节点1"},
                        {name: "子节点2"}
                    ]}
            ];*/

            $.fn.zTree.init($("#treeDemo"), setting, nodes);
        }
    },
})