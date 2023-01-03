var role_app = new Vue({
    el: "#role-page",
    data: {
        rolePageInfo: null,
        tableReady: false,
    },
    methods: {
        generatePagination: function () {
            console.log("got data:\n"+this.getRolePage());
            this.createTable();
        },

        getRolePage: function () {
            const that = this;
            $.ajax({
                url: "admin/get/role/page.json",
                type: "get",
                data: {
                    "pageNum": window.pageNum,
                    "pageSize": window.pageSize,
                    "keyword": window.keyword
                },
                dataType: "json",
                async: false,
                success: function (response) {
                    //console.log(response);
                    if (response.result === "FAILED") {
                        alert(response.message);
                        return null;
                    }
                    that.rolePageInfo = response.data;
                    return response.data;
                    //initPagination(rolePageInfo);
                },
                error: function (response) {
                    console.log(response);
                    return null;
                }

            });
        },

        createTable: function () {
            this.generateNavigator();
            this.tableReady = true;
        },

        generateNavigator: function () {
            var totalRecord = this.rolePageInfo.total;

            var properties = {
                num_edge_entries: 3,
                num_display_entries: 5,
                callback: this.pageSelectCallback,
                items_per_page: this.rolePageInfo.pageSize,
                current_page: this.rolePageInfo.pageNum - 1,
                prev_text: "previous",
                next_text: "next"
            }
            // 生成页码导航条
            $("#Pagination").pagination(totalRecord, properties);
        },

        pageSelectCallback: function (pageIndex, jQuery) {
            window.pageNum = pageIndex + 1;
            this.generatePagination();
            return false;
        },


    }

})