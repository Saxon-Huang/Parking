var role_app = new Vue({
    el: "#role-page",
    data: {
        rolePageInfo: null,
        tableReady: false,
        inputKeyword: "",
        newRoleName: "",
        addRoleResult: "",
    },

    /*created: function () {
        console.log("vue created")
        var currentdate = new Date();
        var datetime = "Last Sync: " + currentdate.getDay() + "/" + currentdate.getMonth()
            + "/" + currentdate.getFullYear() + " @ "
            + currentdate.getHours() + ":"
            + currentdate.getMinutes() + ":" + currentdate.getSeconds();
        console.log(datetime)
    },*/

    mounted: function () {
        this.generatePagination()
    },

    methods: {
        generatePagination: function () {
            this.getRolePage();
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
                        return;
                    }
                    that.rolePageInfo = response.data;
                },
                error: function (response) {
                    console.log(response);
                }

            });
            return null; // TODO:
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

        searchKeyword: function () {
            window.keyword = this.inputKeyword
            this.generatePagination()
        },

        addRole: function () {
            this.addRoleResult = ""
            // console.log(this.newRoleName)
            const that = this
            $.ajax({
                url: "admin/add/role.json",
                type: "post",
                data: {
                    "roleName": this.newRoleName
                },
                dataType: "json",
                async: false,
                success: function (response) {
                    if (response.result === "FAILED") {
                        that.addRoleResult = that.newRoleName + " failed!"
                        return;
                    }
                    that.addRoleResult = "Role [" + that.newRoleName + "] added."
                    console.log(that.rolePageInfo)
                    window.pageNum = that.rolePageInfo.navigateLastPage + 1
                    that.generatePagination()
                },
                error: function (response) {
                    that.addRoleResult = that.newRoleName + " failed!"
                }

            });
        },

        deleteRole: function (roleId) {
            //console.log(roleId)
            const that = this
                $.ajax({
                    url: "admin/remove/role.json",
                    type: "post",
                    data: {
                        "roleId": roleId
                    },
                    dataType: "json",
                    async: false,
                    success: function (response) {
                        console.log(response);
                        that.generatePagination()
                    },
                    error: function (response) {
                        console.log(response);
                    }

                });
        }

    }

})